// Make first letter of a string to a capital letter.
const capOneFirst = str => str.charAt(0).toUpperCase()+str.slice(1);

// Copy to clipboard.
const copyToClipboard = (text) => navigator.clipboard.writeText(text);

// Remove duplicate values from an array.
const arrayRmvDup = (arr) => [... new Set(arr)];

// Odd or Even checker.
const isEven = num => num%2 == 0; const isOdd = num => num%2 != 0;

// Get average value.
const avgValue = ( ... nums) => nums.reduce((a, b) => a + b) / nums.length;

// Reverse a string.
const stringReverse = str => str.split('').reverse().join('');

// Convert RGB to Hex.
const rgbToHex = (r, g, b) => "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);

// Generate Random Hex Color.
const randomHexColor = () => `#${Math.random().toString(16).slice(2,8).padEnd(6,'0')}`;

// Check if an array is empty.
const arrayIsEmpty = () => Array.isArray(arr) && arr.length > 0;

// Shuffle an array.
const shuffle = (arr) => arr.sort(() => 0.5 - Math.random())

// ISSET
const isset = (vari) => typeof vari == 'defined' ? true : false;