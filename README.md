# kt-signal-08

A small Kotlin tool that computes text statistics for signal.

## Objective
- Provide quick text metrics for signal documents.
- Report top word frequencies for fast inspection.

## Use cases
- Validate signal drafts for repeated terms before review.
- Summarize signal notes when preparing reports.

## Usage
kotlinc Main.kt -include-runtime -d textstats.jar && java -jar textstats.jar data/sample.txt --top 5

## Output
- lines: total line count
- words: total word count
- chars: total character count
- top words: most frequent tokens (case-insensitive)

## Testing
- run `bash scripts/verify.sh`

## Notes
- Only ASCII letters and digits are treated as word characters.
