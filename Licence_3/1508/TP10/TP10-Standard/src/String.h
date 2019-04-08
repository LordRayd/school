#ifndef CLASS_STRING
#define CLASS_STRING

#include <cstdlib>
#include <string.h>

class String{
	private :
		const char * str;
	public :
		String(const char * a);
		String(String & s);
		~String();
		int getSize();
		operator const char * () const;
};
inline String operator + (const String s1, const String& s2){
	const char * un = s1;
    const char * deux = s2;
    int nb = (strlen(un)) + (strlen(deux)) + 1;
    char * c = new char[nb];
    strcpy(c, un);
    strcat(c, deux);
    return String(c);
}

inline String operator + (const String s, const char * c){
	return s + String(c);
}

inline String operator+(const char * c, const String s){
	return String(c) + s;
}

#endif
