const leastInterval = (tasks: string[], n: number): number => {
  const freq = tasks.reduce((acc, task) => {
    acc[task] = acc[task] + 1 || 1;
    return acc;
  }, {} as Record<string, number>);

  const maxFreq = Math.max(...Object.values(freq));
  const maxFreqCount = Object.values(freq).filter((v) => v === maxFreq).length;

  return Math.max(
    tasks.length,
    (maxFreq - 1) * (n + 1) + maxFreqCount
  );
}