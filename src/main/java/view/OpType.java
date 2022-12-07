package view;

/**
 * This enum is used to show the two types of expressions a calculator can have.
 * It is then observed by the ViewInterface to choose the right methods to calculate the expression.
 * 
 * @author Rui Favinha
 *
 */
public enum OpType {

  REVPOLISH,

  STANDARD;
}