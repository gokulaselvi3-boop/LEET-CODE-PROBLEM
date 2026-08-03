class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];

        for (int digit : digits) {
            count[digit]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int num = 100; num <= 998; num += 2) {
            int[] temp = new int[10];

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            temp[a]++;
            temp[b]++;
            temp[c]++;

            boolean valid = true;

            for (int i = 0; i < 10; i++) {
                if (temp[i] > count[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
