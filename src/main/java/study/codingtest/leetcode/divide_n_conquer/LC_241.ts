const memo: Map<string, number[]> = new Map();

const diffWaysToCompute = (expression: string): number[] => {
  if (memo.has(expression)) return memo.get(expression);

  const result: number[] = [];
  for (let i = 0; i < expression.length; i++) {
    const char = expression[i];
    if (/[+\-*]/gi.test(char)) {
      const left = diffWaysToCompute(expression.substring(0, i));
      const right = diffWaysToCompute(expression.substring(i + 1));

      for (const l of left) {
        for (const r of right) {
          if (char === "+") result.push(l + r);
          else if (char === "-") result.push(l - r);
          else if (char === "*") result.push(l * r);
        }
      }
    }
  }

  if (result.length === 0) result.push(parseInt(expression));
  memo.set(expression, result);
  return result;
};
