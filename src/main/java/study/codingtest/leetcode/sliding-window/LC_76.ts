const minWindow = (s: string, t: string): string => {
  const need: Map<string, number> = new Map();
  for (const c of t.split("")) {
    need.set(c, (need.get(c) || 0) + 1);
  }
  let missing = t.length;
  let left = 0;
  let right = 0;
  let start = 0;
  let end = 0;
  let minLen = Number.POSITIVE_INFINITY;

  for (const c of s.split("")) {
    right++;
    if (need.has(c) && need.get(c)! > 0) {
      missing--;
    }
    need.set(c, (need.get(c) || 0) - 1);

    if (missing === 0) {
      while (left < right && need.get(s[left])! < 0) {
        need.set(s[left], (need.get(s[left]) || 0) + 1);
        left++;
      }

      if (minLen > right - left + 1) {
        minLen = right - left + 1;
        start = left;
        end = right;
      }
      need.set(s[left], (need.get(s[left]) || 0) + 1);
      missing++;
      left++;
    }
  }
  return s.substring(start, end);
};
