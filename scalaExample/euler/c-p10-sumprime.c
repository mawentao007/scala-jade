#include<stdio.h>
long long array[1000000];
long long point;
long long findPrime(long long);

int main(){
        long long number;
        scanf("%lld",&number);
        array[0] = 2;
        long long ans = findPrime(number);
        printf("%lld\n",ans);
        

}


long long findPrime(long long a){
    long long sum = 2;
    long long next = 3;
    point = 0;
    while(next <=  a){
      sum += next;
      printf("%lld\n",sum);
      array[++point] = next;
      int ptag = 1;
      int i;
			//ptag == 1 当前的不是prime
      while(ptag == 1){
              ptag = 0;
              next += 2;
              for(i=0;i <= point && ptag == 0;i++){
                      if(next % array[i] == 0)
                              ptag = 1;	
              }
      }
    }
    return sum;

}
