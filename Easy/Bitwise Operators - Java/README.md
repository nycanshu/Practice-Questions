<h2><a href="https://www.geeksforgeeks.org/problems/bitwise-operators-java/0">Bitwise Operators - Java</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Bitwise operators are useful when we want to work with bits. Here, we'll take a look at them.</span></p>

<p><span style="font-size:18px">Given three positive integers <strong>a</strong>, <strong>b</strong> and <strong>c</strong>. Your task is to perform some bitwise operations on them as given below:<br>
<strong>1.</strong> d = a ^ a<br>
<strong>2. </strong>e = c ^ b<br>
<strong>3.</strong> f = a &amp; b<br>
<strong>4.</strong> g = c | (a ^ a)<br>
<strong>5.</strong>&nbsp;h&nbsp;= ~e<br>
<strong>Note: ^ </strong>is for xor.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<div class="problemQuestion">
<div class="problemQuestion">
<pre><span style="font-size:18px"><strong>Input:</strong>
4 8 2</span>

<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">0
10
0
2
-11</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<div class="problemQuestion">
<div class="problemQuestion">
<pre><span style="font-size:18px"><strong>Input:</strong>
7 7 7</span>

<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">0
0
7
7
-1</span></pre>
</div>
</div>
</div>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input&nbsp;anything. Your task is to complete the function <strong>bitWiseOp()</strong>&nbsp;which takes <strong>a, b, c</strong>&nbsp;as&nbsp;parameters&nbsp;and print the output for the above-mentioned <strong>bitwise operations</strong>&nbsp;in consecutive lines.</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= A, B, C &lt;= 10<sup>6</sup></span>&nbsp;</p>
</div>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Java-Operators</code>&nbsp;