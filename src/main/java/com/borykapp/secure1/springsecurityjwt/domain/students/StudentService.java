package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.students.exception.StudentNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(format("Can't find student by id [%d]", id)));
    }

    // It starts when the time is full second, ex. when application starts at 11:26:48.000
    // the scheduler starts at 11:27:00.000 and will be updated according to crone job
    // ex. as below starts every full minute, if there would be 5 will start at ex. 11:05:00.000 on
    // every hour 12:05 ... 13:05 etc.
    // https://www.netiq.com/documentation/cloud-manager-2-5/ncm-reference/data/bexyssf.html
    // @Scheduled(fixedRate = time_in_milliseconds) will start after an application has been started
    // and will execute a task on every time_in_milliseconds
    @Scheduled(cron = "15 0/1 * * * ?")
    public void checkStudentsJobScheduler() {
        log.warn("Cron job: ");
        Map<String, LongSummaryStatistics> collect = getAllStudents()
                .stream()
                .collect(groupingBy(Student::getLastName, summarizingLong(Student::getId)));

        collect.forEach((s, longSummaryStatistics) -> {
            log.warn("[{}] occurred [{}]", s, longSummaryStatistics.getCount());
        });
    }

    @Scheduled(cron = "0 0/2 * * * ?")
    public void addRandomStudents() {
        List<String> randomNames = List.of(
                "Eddy, Elliott",
                "Roland, Adams",
                "Jared, Hall",
                "Natalie, Barrett",
                "Aston, Cameron",
                "Stuart, Hill",
                "Catherine, Riley",
                "Savana, Riley",
                "Carlos, Craig",
                "Lyndon, Evans",
                "Lucia, Mason",
                "Dexter, Hamilton",
                "Jordan, Ross",
                "Lenny, Russell",
                "Chelsea, Wells",
                "Michael, Mason",
                "Byron, Walker",
                "Kevin, Hunt",
                "Sienna, Bailey",
                "Edwin, Morrison",
                "Amelia, Allen",
                "Camila, Edwards",
                "Myra, Hamilton",
                "Eleanor, Baker",
                "Chelsea, Baker",
                "Vivian, Tucker",
                "Alissa, Chapman",
                "Alberta, Morris",
                "Andrew, Adams",
                "Abraham, Foster",
                "Edgar, Walker",
                "Violet, Robinson",
                "Andrew, Barrett",
                "Paige, Morrison",
                "Lucia, Higgins",
                "Byron, Wells",
                "Sienna, Morrison",
                "Adele, Warren",
                "Stella, Crawford",
                "James, Richards",
                "Bruce, Murray",
                "Olivia, Walker",
                "Chloe, Adams",
                "James, Williams",
                "Carina, Moore",
                "Alexander, Hamilton",
                "Lydia, Watson",
                "Justin, West",
                "Ryan, Kelly",
                "Jenna, Hall",
                "Richard, Smith",
                "Alen, Owens",
                "Luke, Reed",
                "Adison, Reed",
                "Adison, Stewart",
                "Alen, Crawford",
                "Michelle, Foster",
                "Aldus, Higgins",
                "Brianna, Ferguson",
                "Lana, Hamilton",
                "Lucas, Taylor",
                "Kelsey, Henderson",
                "Carlos, Taylor",
                "Garry, Phillips",
                "Maximilian, Fowler",
                "Tony, Lloyd",
                "Kevin, Sullivan",
                "Michelle, Harper",
                "Kevin, Tucker",
                "Antony, Carroll",
                "Henry, West",
                "Reid, Harrison",
                "Caroline, Roberts",
                "Michelle, Jones",
                "Lydia, Richards",
                "Penelope, Foster",
                "Abraham, Walker",
                "Steven, Smith",
                "Ellia, Rogers",
                "April, Stevens",
                "Lucia, Brooks",
                "George, Jones",
                "Henry, Crawford",
                "Sofia, Gibson",
                "Martin, Farrell",
                "Lydia, Evans",
                "Henry, Perkins",
                "Tiana, Douglas",
                "Antony, Davis",
                "Amelia, Brooks",
                "Michelle, Scott",
                "Edith, Thompson",
                "Chester, Morrison",
                "Tony, Montgomery",
                "Rosie, Johnson",
                "Byron, Spencer",
                "Dainton, Robinson",
                "Lily, Moore",
                "Marcus, Harrison",
                "Alford, Moore");

        int from = (int) (Math.random() * randomNames.size() - 1);
        int to = Math.min(from + 5, randomNames.size());

        List<String> limited = randomNames.subList(from, to);
        limited.stream()
                .map(row -> row.split(","))
                .map(student -> Student.create(student[0], student[1]))
                .forEach(studentRepository::save);

        log.warn("Added some random names! [{}] - [{}]", from, to);
    }
}
