const reconstructQueue = (people: number[][]): number[][] => {
  people.sort((a, b) => b[0] - a[0] || a[1] - b[1]);
  const result: number[][] = [];
  for (const person of people) {
    result.splice(person[1], 0, person);
  }
  return result;
};
