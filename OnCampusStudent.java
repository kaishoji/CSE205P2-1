/*************************************************************************************************
* CLASS: OnCampusStudent.java
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

public class OnCampusStudent extends Student {

  public int RESIDENT = 1;
  public int NON_RESIDENT = 2;
  private int mResident;
  private double mProgramFee;

public OnCampusStudent() {
}

public OnCampusStudent(String pId, String pFirstName, String pLastName) {
  pId = getId();
  pFirstName = getFirstName();
  pLastName = getLastName();
}

// @Override
  /* Declare double variable t
  // If getResidency() returns RESIDENT Then
  // t = TuitionConstants.ONCAMP_RES_BASE
  // Else
 
t = TuitionConstants.ONCAMP_NONRES_BASE
End if
t = t + getProgramFee();
If getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS Then
t = t + (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS)  
TuitionConstants.ONCAMP_ADD_CREDITS
End if
Call setTuition(t)
End Method calcTuition()
*/

@Override
  public void calcTuition() {
    double t;

    if (getResidency() == RESIDENT) {
      t = TuitionConstants.ONCAMP_RES_BASE;
    } else {
      t = TuitionConstants.ONCAMP_NONRES_BASE;
    }

    t = t + getProgramFee();
    
    if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
      t = t + (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS)*TuitionConstants.ONCAMP_ADD_CREDITS;
    }

    setTuition(t);
  }

  public double getProgramFee(){
    return mProgramFee;
  }

  public int getResidency() {
    return mResident;
  }

  public void setProgramFee(double pProgramFee) {
    mProgramFee = pProgramFee;
  }

  public void setResidency(int pResident) {
    mResident = pResident;
  }

}
