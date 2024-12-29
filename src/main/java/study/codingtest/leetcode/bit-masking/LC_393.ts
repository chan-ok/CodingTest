const validUtf8 = (data: number[]): boolean => {
  let start = 0;

  const check = (size: number): boolean => {
    for (let i = start + 1; i < start + size + 1; i++) {
      if (i >= data.length || data[i] >> 6 !== 0b10) {
        return false;
      }
    }
    return true;
  };

  while (start < data.length) {
    const first = data[start];
    if (first >> 3 === 0b11110 && check(3)) {
      start += 4;
    } else if (first >> 4 === 0b1110 && check(2)) {
      start += 3;
    } else if (first >> 5 === 0b110 && check(1)) {
      start += 2;
    } else if (first >> 7 === 0) {
      start += 1;
    } else {
      return false;
    }
  }
  return true;
};
