<h2><a href="https://www.geeksforgeeks.org/problems/rahul-lucky-unlucky5101/1?page=1&sortBy=difficulty">Rahul lucky-unlucky</a></h2><h3>Difficulty Level : Difficulty: Basic</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Rahul is a geek. Head is the lucky call for him. You have to make him lucky. You are provided <strong>N</strong> coins. If the coin is heads facing upwards it means he is lucky else unlucky, your task is to do an operation to make him lucky. Operation allowed is as follows :<br>
Starting from first element, if you find any coin heads facing downwards (Tail), <strong>flip the coin at i<sup>th</sup> index and (i+1)<sup>th</sup> index</strong>. &nbsp;</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
5
H T H T H
<strong>Output:</strong>
2
2 3
<strong>Explanation:
</strong>Coins at index 2 and 3 needs to
be flipped to make Rahul happy.</span>
</pre>

<div><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input:</strong>
3
H H H
<strong>Output:</strong>
0
<strong>Explanation:
</strong>No index to be flipped.</span></pre>

<div>&nbsp;</div>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>flippedIndexes()</strong>&nbsp;which takes the char array <strong>A[]</strong>, its size <strong>N </strong>and<strong> </strong>a <strong>getAnswer[]&nbsp; </strong>array as inputs and returns the <strong>count</strong> of the number of indexes to be flipped and stores the indexes in the <strong>getAnswer[]</strong> array.<br>
<strong>Note:- </strong>If count is zero, you don't need to store anything in the getAnswer[] array.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>7</sup><br>
A[i] = {'H', 'T'}</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;