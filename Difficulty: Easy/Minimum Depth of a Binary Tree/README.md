<h2><a href="https://www.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1?page=1&sortBy=latest">Minimum Depth of a Binary Tree</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a binary tree, find its minimum depth.</span></p>
<p><strong><span style="font-size: 18px;">Examples:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
            1
          /   \
         3     2
        /
       4           </span>

<span style="font-size: 18px;"><strong>Output:</strong> 2</span>
<span style="font-size: 18px;"><strong>Explanation: </strong></span><span style="font-size: 18px;">Minimum depth is between nodes 1 and 2 since minimum depth is defined as  the number of nodes along the shortest path from the root node down to the nearest leaf node.</span></pre>
<p>&nbsp;</p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
             10
          /     \
        20       30
          \        \   
          40        60 
                   /
                  2 </span>

<span style="font-size: 18px;"><strong>Output: </strong>3</span>
<span style="font-size: 18px;"><strong>Explanation:</strong>
Minimum depth is between nodes 10,20 and 40.</span>&nbsp;</pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity: </strong>O(n)<br><strong>Expected Auxiliary Space: </strong>O(height of the tree)</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ Number of nodes ≤ 10^5</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>Facebook</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;