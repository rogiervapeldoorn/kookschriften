package nl.ordina.rogier.kookschriften.client.view;

import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;

/**
 * A column that displays its contents with a {@link ImageCell} and does not make
 * use of view data.
 *
 * @param <T> the row type
 */
public abstract class ImageColumn<T> extends Column<T, String> {

  /**
   * Construct a new ImageColumn.
   */
  public ImageColumn() {
    super(new ImageCell());
  }
}
