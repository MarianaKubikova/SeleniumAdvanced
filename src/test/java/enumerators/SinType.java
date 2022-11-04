package enumerators;

public enum SinType {
  MURDER("murder"),
  ROBBERY("robbery"),
  CAR_ACCIDENT("car accident"),
  HIJACK("hijack"),
  BLACKMAIL("blackmail");

  private String xpathValue;

  SinType(String xpathValue) {
    this.xpathValue = xpathValue;
  }

  public String getXpathValue() {
    return xpathValue;
  }
}
