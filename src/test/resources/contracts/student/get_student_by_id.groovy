package student

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return student by id"

    request {
        url "v1/students/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        id       : '1',
                        firstName: 'John',
                        lastName : 'Banana'
                ]
        )
    }
}