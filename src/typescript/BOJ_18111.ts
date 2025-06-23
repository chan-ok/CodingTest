/**
 * @title 마인크래프트
 * @description 브루트포스
 * @author Chanho Kim
 * @see https://www.acmicpc.net/problem/18111
 */
const fs = require("node:fs");
const inputTarget =
  process.platform === "linux" ? "/dev/stdin" : `${__dirname}/input.txt`;
const input: string[] = fs.readFileSync(inputTarget, "utf8").trim().split("\n");
const [, , B] = input[0].split(" ").map(Number);
const heightMap: Map<number, number> = new Map();
const map: number[] = [];
input
  .slice(1)
  .map((line) => line.split(" ").map(Number))
  .forEach((row) =>
    row.forEach((point) => {
      heightMap.set(point, (heightMap.get(point) ?? 0) + 1);
      map.push(point);
    })
  );
map.sort((a, b) => a - b);

const maxHeight = Math.min(256, Math.max(...Array.from(heightMap.keys())));
const minHeight = Math.max(0, Math.min(...Array.from(heightMap.keys())));

const underPrefixSum: Map<number, number[]> = new Map();
for (let h = minHeight; h <= maxHeight; h++) {
  const heightCount = heightMap.get(h) ?? 0;
  const prev = underPrefixSum.get(h - 1) ?? [0, 0];
  underPrefixSum.set(h, [prev[0] + heightCount * h, prev[1] + heightCount]);
}
const overPrefixSum: Map<number, number[]> = new Map();
for (let h = maxHeight; h >= minHeight; h--) {
  const heightCount = heightMap.get(h) ?? 0;
  const prev = overPrefixSum.get(h + 1) ?? [0, 0];
  overPrefixSum.set(h, [prev[0] + heightCount * h, prev[1] + heightCount]);
}

const processQueue: { height: number; time: number }[] = [];
for (let height = maxHeight; height >= minHeight; height--) {
  const over = overPrefixSum.get(height) ?? [0, 0];
  const under = underPrefixSum.get(height) ?? [0, 0];
  // TODO: 1. 평탄화 가능한지 검증하는 로직 재수정
  const canFlatten =
    under[1] * height - under[0] <= B + over[0] - over[1] * height;
  if (!canFlatten) continue;

  // TODO: 2. 평탄화 시간 계산 로직 재수정

  const needUnder = under[1] * height - under[0];
  const needOver = over[0] - over[1] * height;
  const time = needUnder + needOver * 2;
  processQueue.push({ height, time });
}

const compare = (
  a: { height: number; time: number },
  b: { height: number; time: number }
) => {
  if (a.time === b.time) {
    return b.height - a.height;
  }
  return a.time - b.time;
};
processQueue.sort(compare);
const { height, time } = processQueue[0];

console.log(time, height);
