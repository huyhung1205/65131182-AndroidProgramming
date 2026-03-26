package hyhung.docbaotonghop;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class RssFeed {
    @Element(name = "channel", required = false)
    private RssChannel channel;

    public RssFeed() {
    }

    public RssChannel getChannel() {
        return channel;
    }

    public void setChannel(RssChannel channel) {
        this.channel = channel;
    }
}
