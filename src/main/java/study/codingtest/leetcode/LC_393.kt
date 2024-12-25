fun checkUtf8(data: IntArray, start: Int, size: Int): Boolean {
  for (i in start + 1 until start + size + 1) {
    if (i >= data.size || data[i] shr 6 != 0b10) {
      return false
    }
  }
  return true
}

fun validUtf8(data: IntArray): Boolean {
  var start = 0
  while (start < data.size) {
    val first = data[start]
    if (first shr 3 == 0b11110 && checkUtf8(data, start, 3)) {
      start += 4
    } else if (first shr 4 == 0b1110 && checkUtf8(data, start, 2)) {
      start += 3
    } else if (first shr 5 == 0b110 && checkUtf8(data, start, 1)) {
      start += 2
    } else if (first shr 7 == 0) {
      start += 1
    } else {
      return false
    }
  }
  return true
}
