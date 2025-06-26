/**
 * @title 테트로미노 (14500)
 * @description 테트로미노 5가지 모양을 모두 탐색하여 최대 합을 구하는 문제
 * @author Chanho Kim
 * @see https://www.acmicpc.net/problem/14500
 */
const fs = require("node:fs");
const inputTarget =
  process.platform === "linux" ? "/dev/stdin" : `${__dirname}/input.txt`;
const input: string[] = fs.readFileSync(inputTarget, "utf8").trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
const board = input.slice(1).map((row) => row.split(" ").map(Number));
const getFlippedBoard = (board: number[][]) => {
  return board.map((row) => row.map((_, i) => row[row.length - 1 - i]));
};
const getRotatedBoard = (board: number[][]) => {
  const arr = Array.from({ length: M }, () => []);
  board.forEach((row, i) => {
    row.forEach((_, j) => {
      arr[j][i] = row[j];
    });
  });
  return arr;
};

const flippedBoard = getFlippedBoard(board);
const rotatedBoard = getRotatedBoard(board);
const flippedRotatedBoard = getFlippedBoard(rotatedBoard);
const boards = [board, flippedBoard, rotatedBoard, flippedRotatedBoard];

const tetrominoInSixTiles = [
  [
    // ㄱ
    [0, 0],
    [0, 1],
    [1, 1],
    [2, 1],
  ],
  [
    // ㄴ
    [0, 0],
    [1, 0],
    [2, 0],
    [2, 1],
  ],
  [
    // 2
    [1, 0],
    [1, 1],
    [0, 1],
    [2, 0],
  ],
  [
    // 5
    [1, 0],
    [1, 1],
    [0, 0],
    [2, 1],
  ],
  [
    // ㅁ1
    [0, 0],
    [0, 1],
    [1, 0],
    [1, 1],
  ],
  [
    // ㅁ2
    [1, 0],
    [1, 1],
    [2, 0],
    [2, 1],
  ],
  [
    // ㅓ
    [0, 1],
    [1, 1],
    [2, 1],
    [1, 0],
  ],
  [
    // ㅏ
    [0, 0],
    [1, 0],
    [2, 0],
    [1, 1],
  ],
];

let maxSum = 0;
for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    const sumsInSixTiles: number[] = [];
    tetrominoInSixTiles.forEach((tetromino) => {
      boards.forEach((b) => {
        let sum = 0;
        let rotatedSum = 0;
        tetromino.forEach(([row, col]) => {
          sum += b[r + row]?.[c + col] ?? 0;
          rotatedSum += b[c + row]?.[r + col] ?? 0;
        });
        sumsInSixTiles.push(sum, rotatedSum);
      });
    });
    let verticalSum = 0;
    let horizontalSum = 0;
    [0, 1, 2, 3].forEach((i) => {
      verticalSum += board[r + i]?.[c] ?? 0;
      horizontalSum += board[r]?.[c + i] ?? 0;
    });
    maxSum = Math.max(maxSum, ...sumsInSixTiles, verticalSum, horizontalSum);
  }
}

console.log(maxSum);
