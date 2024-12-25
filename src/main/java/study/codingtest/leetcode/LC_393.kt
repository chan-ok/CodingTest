fun validUtf8(data: IntArray): Boolean {
  var start = 0

  fun check(size: Int): Boolean {
    for (i in start + 1 until start + size + 1) {
      if (i >= data.size || data[i] shr 6 != 2) {
        return false
      }
    }
    return true
  }

  while (start < data.size) {
    val first = data[start]
    when {
      first shr 3 == 30 && check(3) -> start += 4
      first shr 4 == 14 && check(2) -> start += 3
      first shr 5 == 6 && check(1) -> start += 2
      first shr 7 == 0 -> start += 1
      else -> return false
    }
  }
  return true
}
