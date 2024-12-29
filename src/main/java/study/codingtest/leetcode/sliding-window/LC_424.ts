const characterReplacement = (s: string, k: number): number => {
  let left = 0;
  const counts: Map<string, number> = new Map();

  for (let right = 1; right <= s.length; right++) {
    counts.set(s[right - 1], (counts.get(s[right - 1]) || 0) + 1);
    const maxCharCount = Math.max(...Array.from(counts.values()));

    if (right - left - maxCharCount > k) {
      counts.set(s[left], (counts.get(s[left]) || 0) - 1);
      left++;
    }
  }
  return s.length - left;
};
