# Lab 13 — REST design notes (TODO)

## URI table

| Resource | Method | URI                         | Success status |
| -------- | ------ |-----------------------------|----------------|
| Collection list | GET | `/api/v1/customers`         | 200            |
| Create | POST | `/api/v1/customers`         | 201            |
| Item | GET | `/api/v1/customers/{customerId}` | 200            |
| Replace | PUT | `/api/v1/customers/{customerId}` | 200            |
| Delete | DELETE | `/api/v1/customers/{customerId}`                            | 204            |
| Patch status | PATCH | `/api/v1/customers/{customerId}/status`                            | 200            |

## Error contract

- Header: `X-Correlation-Id` (example `lab-request-001`)
- Body fields: timestamp, status, error, message, path, correlationId
- TODO: {
  "timestamp": "",
  "status": 404,
  "error": "Not Found",
  "message": "Customer CUS-9999 not found",
  "path": "/customers/CUS-9999",
  "correlationId": "lab-request-001"
  }

## Pagination / filter / sort

- `page`, `size` (max ?), `status`, `sort`
- Example list URL: GET /api/v1/customers?status=ACTIVE&page=0&size=20&sort=fullName,asc
- Page wrapper fields: content, page, size, totalElements

## Fixtures

- `CUS-1001` Amina Khan ACTIVE
- `CUS-1002` Ravi Singh PROSPECT

## Stack reminder

REST / OpenAPI · Angular client later · PostgreSQL later · GitHub Actions later — not SOAP/Oracle as the taught path.
