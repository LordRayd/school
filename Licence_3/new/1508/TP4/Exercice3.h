#ifndef CLASS_STRING
#define CLASS_STRING

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

#endif