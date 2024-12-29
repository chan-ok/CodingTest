const singleNumber = (n: number[]) => n.reduce((a, c) => a ^ c, 0);
