package com.company.designPattern.facade;

// facade 적용한 것 : 객체를 한번 감쌌다 -> 의존성을 SftpClient가 가져갔고, 새로운 인터페이스를 제공한다.
public class SftpClient {

    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    // 생성자 오버로딩
    public SftpClient(String host, int port, String path, String fileName ) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect(){
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect(){
        writer.fileDisconnect();
        reader.fileDisconnect();
        ftp.disConnect();
    }

    public void read(){
        reader.fileRead();
    }

    public void write(){
        writer.write();
    }

}
