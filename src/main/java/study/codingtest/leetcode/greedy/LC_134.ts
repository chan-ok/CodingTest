const canCompleteCircuit = (gas: number[], cost: number[]): number => {
  if (gas.reduce((a, g) => a + g, 0) < cost.reduce((a, c) => a + c, 0)) {
    return -1;
  }
  let start = 0;
  let tank = 0;
  for (let i = 0; i < gas.length; i++) {
    if (tank + gas[i] <= cost[i]) {
      start = i + 1;
      tank = 0;
    } else {
      tank += gas[i] - cost[i];
    }
  }
  return start;
};
