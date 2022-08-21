class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int spareEnergy = 0, sum = 0, spareX = 0, curX = initialExperience, spare = 0;
        for(int i=0;i<energy.length;i++){
            sum += energy[i];
            spare = (experience[i] >= curX) ? experience[i] - curX + 1 : 0;
            spareX += spare;
            curX += (experience[i] + spare);
        }
        spareEnergy = (sum >= initialEnergy) ? sum - initialEnergy + 1 : 0;
        return spareX + spareEnergy;
    }
}