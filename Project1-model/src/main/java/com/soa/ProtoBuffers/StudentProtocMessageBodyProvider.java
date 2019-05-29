package com.soa.ProtoBuffers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


@Provider
@Produces("application/protobuf")
@Consumes("application/protobuf")
public class StudentProtocMessageBodyProvider
        implements MessageBodyReader, MessageBodyWriter {

    @Override
    public boolean isReadable(Class type, Type type1,
                              Annotation[] antns, MediaType mt) {
        return StudentsProto.Student.class.isAssignableFrom(type)
                || StudentsProto.StudentsList.class.isAssignableFrom(type);
    }

    @Override
    public Object readFrom(Class type, Type type1, Annotation[] antns,
                           MediaType mt, MultivaluedMap mm, InputStream in)
            throws IOException, WebApplicationException {
        if (StudentsProto.Student.class.isAssignableFrom(type)) {
            return StudentsProto.Student.parseFrom(in);
        } else if (StudentsProto.StudentsList.class.isAssignableFrom(type)) {
            return StudentsProto.StudentsList.parseFrom(in);
        } else {
            throw new BadRequestException("Can't Deserailize");
        }
    }

    @Override
    public boolean isWriteable(Class type, Type type1,
                               Annotation[] antns, MediaType mt) {
        return StudentsProto.Student.class.isAssignableFrom(type)
                || StudentsProto.StudentsList.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Object t, Class type, Type type1,
                        Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(Object t, Class type, Type type1,
                        Annotation[] antns, MediaType mt,
                        MultivaluedMap mm, OutputStream out)
            throws IOException, WebApplicationException {
        if (t instanceof StudentsProto.Student) {
            StudentsProto.Student student = (StudentsProto.Student) t;
            student.writeTo(out);
        } else if (t instanceof StudentsProto.StudentsList) {
            StudentsProto.StudentsList list = (StudentsProto.StudentsList) t;
            list.writeTo(out);
        }
    }
}
