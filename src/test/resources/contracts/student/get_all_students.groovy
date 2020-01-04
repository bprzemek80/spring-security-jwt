package student

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return all students"

    request {
        url "v1/students"
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
                                id       : '1',
                                firstName: 'John',
                                lastName : 'Squirrel'
                        ],
                        [
                                id       : '2',
                                firstName: 'Adam',
                                lastName : 'Bear'
                        ],
                ]
        )
    }
}