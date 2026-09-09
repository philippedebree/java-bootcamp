# Collection choices

| # | Scenario | Need (order / unique / key→value / sorted) | Interface          | Implementation | Why |
| - | -------- | ------------------------------------------ |--------------------|----------------| --- |
| 1 | Ordered catalog; duplicate titles allowed | | `List<Book>`       | `ArrayList<>`  | |
| 2 | Unique registered book IDs | | `Set<String>`      | `HashSet<>`    | |
| 3 | Book ID → current borrower ID | | `Map<String, String>` | `HashMap<>`    | |
| 4 | Alphabetically sorted categories | | `Set<String>` | `TreeSet<>`    | |
| 5 | Category → count, sorted by category | | `Map<String, Integer>` | `TreeMap<>`    | |
| 6 | Checkout history in event order | | `List<BorrowRecord>` | `ArrayList<>`  | |