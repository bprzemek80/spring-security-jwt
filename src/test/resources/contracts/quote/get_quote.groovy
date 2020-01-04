package quote

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should get quote"

    request {
        url "v1/quote"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        quote: 'Sample quote',
                        quoteId: 1,
                        type: 'Type1'
                ]
        )
    }
}