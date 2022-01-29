/*************************************************************************************************
* CLASS: OnlineStudent.java
*
* DESCRIPTION
* A description of the contents of this file.
*
* COURSE AND PROJECT INFORMATION
* CSE205 Object Oriented Programming and Data Structures, Spring 2022 Session A
* Project Number: 2
*
* AUTHOR: Justin Fernandes, Asurite ID: 1223222572, jferna56@asu.edu
* AUTHOR: Kai Ohsawa, Asurite ID: 121643600, kaishoji.oh@gmail.com
* AUTHOR: Tony Wen, Asurite ID: 1222943787, tewen@asu.edu
******************************************************************************************************/
public class OnlineStudent extends Student {
  
  private boolean mTechFee;

  public OnlineStudent() {
  }


  public OnlineStudent (String pId, String pFirstName, String pLastName) { 
    pId = getId();
    pFirstName = getFirstName();
    pLastName = getLastName();
  }
  
  @Override
  public void calcTuition() {
    
    double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
    if (getTechFee() == true) {
      t = t + TuitionConstants.ONLINE_TECH_FEE;
    }
    setTuition(t);
  }
  
  public boolean getTechFee() {
    return mTechFee;
  }

  public void setTechFee(boolean pTechFee) {
    mTechFee = pTechFee;
  }

}