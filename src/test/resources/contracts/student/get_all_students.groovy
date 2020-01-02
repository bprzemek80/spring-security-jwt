package student

import org.springframework.cloud.contract.spec.Contract

import java.time.LocalDate

def fixDate = LocalDate.of(2020, 1, 1)

Contract.make {
    description "should return all students"

    request {
        url "/students"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        [
                                studentId      : '1',
                                firstName      : 'John',
                                lastName       : 'Squirrel'
                        ],
                        [
                                studentId      : '2',
                                firstName      : 'Adam',
                                lastName       : 'Bear'
                        ],
                ]
        )
    }
}