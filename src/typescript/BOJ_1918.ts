/**
 * @title 후위 표기식
 * @description 스택
 * @author Chanho Kim
 * @see https://www.acmicpc.net/problem/1918
 */
const fs = require("node:fs");
const inputTarget =
  process.platform === "linux" ? "/dev/stdin" : `${__dirname}/input.txt`;
const input = fs.readFileSync(inputTarget, "utf8").trim().split("\n");
const expression = input[0].split("");

function infixToPostfix(expression: string[]): string {
  while (hasBracket(expression)) {
    const [before, inBracket, after] = splitExpression(expression);
    expression = [...before, findOperatorAndCalculate(inBracket), ...after];
  }
  return findOperatorAndCalculate(expression);
}

function hasBracket(expression: string[]) {
  return expression.includes("(");
}

function splitExpression(expression: string[]) {
  const lastOpenBracket = expression.lastIndexOf("(");
  const nearCloseBracket = expression.indexOf(")", lastOpenBracket);
  return [
    expression.slice(0, lastOpenBracket),
    expression.slice(lastOpenBracket + 1, nearCloseBracket),
    expression.slice(nearCloseBracket + 1),
  ];
}

function findOperatorAndCalculate(expression: string[]) {
  let foundIdx: number;
  while ((foundIdx = findMultiplyDivide(expression)) !== -1) {
    calculate(expression, foundIdx);
  }
  while ((foundIdx = findPlusMinus(expression)) !== -1) {
    calculate(expression, foundIdx);
  }
  return expression.join("");
}

function findMultiplyDivide(expression: string[]) {
  return expression.findIndex((char) => char === "*" || char === "/");
}

function findPlusMinus(expression: string[]) {
  return expression.findIndex((char) => char === "+" || char === "-");
}

function calculate(expression: string[], foundIdx: number) {
  const [before, op, after] = expression.slice(foundIdx - 1, foundIdx + 2);
  const calculated = before + after + op;
  expression.splice(foundIdx - 1, 3, calculated);
}


console.log(infixToPostfix(expression));
