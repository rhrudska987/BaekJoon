class Solution {
    
    static boolean[] visited;
    static int minStepCnt = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];

		for (int i = 0; i < words.length; i++) {
			int sameCnt = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j)) {
					sameCnt++;
				}
			}

			if (sameCnt < begin.length() - 1) {
				continue;
			}

			visited[i] = true;
			dfs(words[i], target, words, 1);
			visited[i] = false;
		}
        
        if (minStepCnt == Integer.MAX_VALUE) {
            return 0;
        }

		return minStepCnt;
	}
    
    public void dfs(String begin, String target, String[] words, int stepCnt) {
		if (begin.equals(target)) {
			minStepCnt = Math.min(stepCnt, minStepCnt);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i]) {
				continue;
			}

			int sameCnt = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j)) {
					sameCnt++;
				}
			}

			if (sameCnt < begin.length() - 1) {
				continue;
			}

			visited[i] = true;
			dfs(words[i], target, words, stepCnt + 1);
			visited[i] = false;
		}

	}
}