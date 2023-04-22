class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int k, int n) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        ArrayList<Integer> res=new ArrayList<>();
        
        int nums[]=new int[9];
        for(int i=1;i<=9;i++)
        {
            nums[i-1]=i;
        }
        
        if(k>n) return ans;
        
        comb(0,nums,res,ans,k,n);
        return ans;
    }
    public static void comb(int idx,int nums[],ArrayList<Integer> res,
                            ArrayList<ArrayList<Integer>> ans,int k, int n)
    {
        if(res.size()==k && n==0 && !res.contains(0))
        {
            ans.add(new ArrayList<>(res));
        }
        
        for(int i=idx;i<nums.length;i++)
        {
            if (n < nums[i]) {
                break;
            }
            if(i!=idx && nums[i]==nums[i-1])
            {
                continue;
            }
                res.add(nums[i]);
                
                comb(i+1,nums,res,ans,k,n-nums[i]);
                res.remove(res.size()-1);
                
        }
    }
}
