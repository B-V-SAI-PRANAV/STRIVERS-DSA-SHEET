class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start,int end,int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class MeetingComparator implements Comparator<Meeting>{
    public int compare(Meeting m1,Meeting m2){
        if(m1.end<m2.end){
            return -1;
        }
        else if (m1.end>m2.end){
            return 1;
        }
        else if(m1.pos<m2.pos){
            return -1;
        }
        return 1;
    }
}
class Solution {
  
    public int maxMeetings(int start[], int end[]) {
        ArrayList<Meeting> meet=new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meet.add(new Meeting(start[i],end[i],i+1));
        }
        MeetingComparator mc=new MeetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer> ans=new ArrayList<>();
        int answer=meet.get(0).pos;
        int limit=meet.get(0).end;
        ans.add(answer);
        for(int i=1;i<start.length;i++){
            if(meet.get(i).start > limit){
                limit=meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        return ans.size();
    }
}
