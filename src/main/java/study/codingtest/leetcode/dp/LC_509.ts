const fib = (n: number, x = 0, y = 1) => (n === 0 ? x : fib(n - 1, y, x + y));
