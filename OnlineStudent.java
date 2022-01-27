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
* AUTHOR: your-name, your-asuriteid, your-email-addr ** Note: Include a second author line if
* Author: Kai Ohsawa, Asurite ID: 1216436000, kaishoji.oh@gmail.com
* Author: Tony Wen, Asurite ID: 1222943787, tewen@asu.edu
******************************************************************************************************/
public class OnlineStudent extends Student {
  
  private boolean mTechFee;

  public OnlineSudent() {
    
  }

  public OnlineStudent (String pId, String pFirstName, String pLastName){
    pId = mId;
  }
  
  @Override
  public void calcTuition() {
    
    double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
    if (getTechFee() == true) {
      t = t + TuitionConstants.ONLINE_TECH_FEE;
    }
    setTuition(t);
  }

}