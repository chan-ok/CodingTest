fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
  if (gas.sum() < cost.sum()) {
    return -1;
  }

  var start = 0;
  var tank = 0;
  for (i in gas.indices) {
    if (tank + gas[i] <= cost[i]) {
      start++;
      tank = 0;
    } else {
      tank += gas[i] - cost[i];
    }
  }
  return start;
}