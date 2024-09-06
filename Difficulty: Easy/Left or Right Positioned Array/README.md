<h2><a href="https://www.geeksforgeeks.org/problems/left-or-right-positioned-array5757/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card">Left or Right Positioned Array</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>arr[]</strong> of size <strong>n&gt;3</strong>, the task is to check whether the given array can be <strong>arranged</strong> in the form of a Left or Right positioned array?<br>
<strong>Left or Right Positioned Array</strong> means each element in the array is equal to the number of elements to its left or number of elements to its right.</span><br>
<span style="font-size:18px"><strong>Note: 1 </strong>represents<strong> true </strong>and<strong> 0 </strong>represents<strong> false.</strong></span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input  : </strong>
arr[] = {1, 3, 3, 2}
<strong>Output : </strong>
1
<strong>Explanation :</strong>
This array has one such arrangement {3, 1, 2, 3}.
In this arrangement, first element '3' indicates
that three numbers are after it, the 2nd element
'1' indicates that one number is before it, the
3rd element '2' indicates that two elements are
before it.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input : </strong>
arr[] = {1, 6, 5, 4, 3, 2, 1}
<strong>Output :</strong>
0
<strong>Explanation :
</strong>No such arrangement is possible</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 3:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input : </strong>
arr[] = {2, 0, 1, 3}
<strong>Output: </strong>
1
<strong>Explanation :</strong>
Possible arrangement is {0, 1, 2, 3}</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 4:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input : </strong>
arr[] = {2, 1, 5, 2, 1, 5}
<strong>Output : </strong>
"1"
<strong>Explanation :</strong>
Possible arrangement is {5, 1, 2, 2, 1, 5}</span>
</pre>

<p><br>
<br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to print anything, printing is done by the driver code. You have to complete the function <strong>leftRight()</strong> which takes the array <strong>arr[]</strong> and its size <strong>N</strong><strong> </strong>as inputs and returns <strong>True</strong> if the array can be arranged to form left or right positioned array, else <strong>False</strong> as the answer.</span><br>
&nbsp;</p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity: </strong>O(N)<br>
<strong>Expected Auxiliary Space: </strong>O(N)</span></p>

<p><br>
<br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
4 ≤ N ≤ 100000<br>
0 ≤ arr[i] ≤ 1000</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;