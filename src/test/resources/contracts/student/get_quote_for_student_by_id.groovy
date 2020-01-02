package student

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return quote for student by id"

    request {
        url "/students/1/quote"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        type    : 'Type1',
                        value   : [
                                id: 1,
                                quote: 'Sample quote'
                        ],
                        student: [
                                studentId: 1,
                                firstName: 'John',
                                lastName: 'Banana'
                        ]
                ]
        )
    }
}