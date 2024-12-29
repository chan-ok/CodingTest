const hammingDistance = (x: number, y: number): number => {
  let xor = x ^ y;
  let count = 0;
  while (xor) {
    count += xor & 1;
    xor = xor >> 1;
  }
  return count;
};
