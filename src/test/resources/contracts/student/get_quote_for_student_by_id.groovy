package student

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return quote for student by id"

    request {
        url "v1/students/1/quote"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        type   : 'Type1',
                        quote  : 'Sample quote',
                        quoteId: 1,
                        student: [
                                firstName: 'John',
                                lastName : 'Banana'
                        ]
                ]
        )
    }
}
