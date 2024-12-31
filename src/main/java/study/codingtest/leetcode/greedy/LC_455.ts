const findContentChildren = (g: number[], s: number[]): number => {
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);
  let i = 0;
  s.forEach((size) => {
    if (size >= g[i]) {
      i++;
    }
  });
  return i;
};
