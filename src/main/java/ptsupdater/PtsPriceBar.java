package ptsupdater;

//import com.jsystemtrader.platform.quote.*;
//import com.opentick.*;

import java.text.*;
import java.util.*;

/**
 * Encapsulates the price bar information.
 */
public class PtsPriceBar {

  private long date;
  private double open, high, low, close;
  private long volume;


  /**
   * This constructor is used to create a new historical bar
   */
  public PtsPriceBar(long date, double open, double high, double low, double close, long volume) {
    this.date = date;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
  }

  /**
   * rpc - 3/5/10 5:02 PM - Instantiate a PriceBar  with IB MarketData last value
   * coming from MarketDataConnection.tickPrice().
   * @param dateIn long date format
   * @param tick the last field from
   */
  public PtsPriceBar(long dateIn, double tick) {
    date = dateIn;
    open = high = low = close = tick;
    volume = 0;
  }

  // rpc - 2/8/10 6:40 PM Copy Constructor for PriceBarDrawDowns.
  public PtsPriceBar(PtsPriceBar barIn) {
    this.date = barIn.date;
    this.open = barIn.open;
    this.high = barIn.high;
    this.low = barIn.low;
    this.close = barIn.close;
    this.volume = barIn.volume;
  }


  /**
   * This constructor used to create a new real time bar
   */
  public PtsPriceBar(double open, double high, double low, double close, long volume) {
    this(0, open, high, low, close, volume);
  }

  /**
   * This constructor used to create a new real time bar whose OHLC values
   * are the same as the last completed bar.
   */
  public PtsPriceBar(double price) {
    this(0, price, price, price, price, 0);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" date: ").append(getShortDate());
    sb.append(" open: ").append(open);
    sb.append(" high: ").append(high);
    sb.append(" low: ").append(low);
    sb.append(" close: ").append(close);
    sb.append(" volume: ").append(volume);

    return sb.toString();
  }

  public double getOpen() {
    return open;
  }

  public double getHigh() {
    return high;
  }

  public double getLow() {
    return low;
  }

  public double getClose() {
    return close;
  }

  public double getMidpoint() {
    return (low + high) / 2;
  }

  public void setOpen(double open) {
    this.open = open;
  }

  public void setHigh(double high) {
    this.high = high;
  }

  public void setLow(double low) {
    this.low = low;
  }

  public void setClose(double close) {
    this.close = close;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public long getVolume() {
    return volume;
  }

  public long getDate() {
    return date;
  }

  public String getShortDate() {
      return PtsDateOps.nowPrettyString(); //dateFormat.format(new Date(date));
  }
}
