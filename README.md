# FakeRESTApi Books API Automation

This project implements the API section of the supplied Senior Software QC Automation Assessment.

## Stack
Java 17, REST Assured, TestNG, Maven.

## Design
- Service Object Model: `BooksService`
- Reusable request configuration: `BaseApi`
- OOP request model: `Book`
- Externalized data: `src/test/resources/test-data/books.json`
- Environment configuration: `config.properties`
- Failure-only request/response logging
- No hard-coded base URL in tests

## Coverage
1. Happy path: GET all books
2. Happy path: POST/create a book
3. Happy path: PUT/update a book
4. Happy path: DELETE a book
5. Negative/edge case: GET book using a non-existent ID (999999)

`BooksService` covers all 5 Books API endpoints: `GET /Books`, `GET /Books/{id}`, `POST /Books`, `PUT /Books/{id}`, `DELETE /Books/{id}`.

The assessment says FakeRESTApi may simulate create/update/delete without permanently storing data, so assertions validate the returned response rather than assuming persistence.

### Unexpected behaviour notes
- FakeRESTApi does not perform real ID validation: requesting a non-existent book ID can return `200` with a generated payload instead of `404`. The negative test tolerates both outcomes and logs a note when `200` is observed.
- Create/Update/Delete operations are not persisted server-side (in-memory simulation), so a subsequent GET may not reflect prior writes. Tests validate the immediate response only, not cross-request persistence.


## Endpoint
`https://fakerestapi.azurewebsites.net/api/v1/Books`

## Run
`mvn clean test`

## Git
`git init`
`git add .`
`git commit -m "Add FakeRESTApi Books API automation assessment"`
