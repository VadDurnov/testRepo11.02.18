
public class TestClass {

	public static int sort(int[] array, int l, int r) {
		int counter = 0;
		if (l < r ) {
			int m = (l+r) / 2;
			
			counter = sort(array, l, m);
			counter += sort(array, m+1, r);
			
			counter += merge(array, l, m, r);
		}
		return counter;
	}
	public static int merge(int[] array, int l, int m, int r) {
		
		int s1 = m - l + 1;
		int s2 = r - m;
		
		int[] F1 = new int[s1];
		int[] F2 = new int[s2];
		
		for (int i=0; i<s1; i++) {
			F1[i] = array[l+i];
		}
		for (int i=0; i<s2; i++) {
			F2[i] = array[m + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		int counter = 0;
		while (i < s1 && j < s2) {                                 
        	if (F1[i] <= F2[j]) {                                                 
        		array[k] = F1[i];                                                    
        		i++;                                                             
        		k++;                                                             
        	} else {                                                             
        		array[k] = F2[j];                                                    
        		k++;                                                             
        		j++;         
        		counter += m - i; 
        	}
        }
       
        while (i < s1) {
        	array[k] = F1[i];
        	i++;
        	k++;
        }
        while (j < s2) {
        	array[k] = F2[j];
        	j++;
        	k++;
        }
        return counter;
	}
}
