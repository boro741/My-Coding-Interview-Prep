// CPP Program to find maximum XOR value of a pair 
#include<iostream> 
using namespace std;

int equals(string a,string b){
	int f[26]={0};
	for(auto x:a){
		f[x-'a']++;
	}
	int ans=0;
	for(auto x:b){
		if(f[x-'a']>0){
			f[x-'a']--;
		}
		else{
			ans++;
		}
	}
	return ans;
}
int cal(string a,string b){
	int cnt=0;
	for(int i=0;i<a.size();i++){
		if(a[i]=='z') a[i]='a' , cnt++;
		if(b[i]=='a') b[i]='z' , cnt++;
	}
	int ans=0;
	int f[26]={0};
	for(auto x:b){
		f[x-'a']++;
	}
	sort(a.begin(),a.end());
	sort(b.begin(),b.end());
	bool go;
	for(auto x:a){
		go=1;
		for(int j=int(x-'a')+1;j<26;j++){
			if(f[j]>0){
				f[j]--;
				go=0;
				break;
			}
		}
		if(go) ans++;
	}
	ans+=cnt;
	return ans;
}
int main(){
	string s = "n";
    //cin>>s;
    char c;
    for(int i = 0; i < s.length();i++){
        c = char(int(s[i]+s[i]-'a')%26 +'a');
        cout<<c;
    }
	cout<<endl;
    return 0;
}