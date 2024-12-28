fun characterReplacement(s: String, k: Int): Int {
  var left = 0
  val counts: MutableMap<Char, Int> = mutableMapOf()

  for(right in 1..s.length) {
    counts[s[right - 1]] = counts.getOrDefault(s[right - 1], 0) + 1
    val maxCharCount = counts.values.maxOrNull() ?: 0

    if (right - left - maxCharCount > k) {
      counts[s[left]] = counts.getOrDefault(s[left], 0) - 1
      left++
    }
  }
  return s.length - left
}